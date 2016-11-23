#include <sys/statvfs.h>
#include <sys/types.h>

#include <ctype.h>
#include <dirent.h>
#include <procfs.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <utmpx.h>

#include "jni_stub.h"

struct process_struct {
  char pid[16];
  long jiffies;
  char name[128];
  struct process_struct *next;
};

typedef struct process_struct PROCESS_STRUCT;

/*
**
*/
JNIEXPORT jlong JNICALL Java_com_bgi_essa_jboss4_jmx_JniStub_getBootTime(JNIEnv *env, jobject arg) {
	struct utmpx id;
	struct utmpx *uu;
	long result = 0L;

	setutxent();

	id.ut_type = BOOT_TIME;
	uu = getutxid(&id);

	if (uu == NULL) {
		return(result);
	}

	result = (uu->ut_tv.tv_sec) * 1000L;

	return(result);
}

/*
**
*/ 
JNIEXPORT jstring JNICALL Java_com_bgi_essa_jboss4_jmx_JniStub_getVersion(JNIEnv *env, jobject arg) {
	char buffer[64];
	jstring result;

	sprintf(buffer, "libstub compiled on %s at %s", __DATE__, __TIME__);
	result = (*env)->NewStringUTF(env, buffer);
	return(result);
}

/*
**
*/
JNIEXPORT jstring JNICALL Java_com_bgi_essa_jboss4_jmx_JniStub_getStatVfs(JNIEnv *env, jobject arg, jstring target) {
	char *path;
	char buffer[255];
	jstring result;
	int retstatus;
	struct statvfs datum;

	path = (*env)->GetStringUTFChars(env, target, NULL);

	retstatus = statvfs(path, &datum);

	sprintf(buffer, "%ld %ld %ld %ld %ld %ld %ld %ld", datum.f_bsize, datum.f_frsize, datum.f_blocks, datum.f_bfree, datum.f_bavail, datum.f_files, datum.f_ffree, datum.f_favail);

	result = (*env)->NewStringUTF(env, buffer);

	return(result);
}

/*
** Return populated process structure.
*/
PROCESS_STRUCT *read_datum(char *arg) {
  char buffer[1024];
  PROCESS_STRUCT *temp;
  psinfo_t ps_info;
  FILE *fp;

  sprintf(buffer, "/proc/%s/psinfo", arg);

  if ((fp = fopen(buffer, "r")) == NULL) {
    printf("fopen failure\n");
    return(NULL);
  }

  if (fread(&ps_info, sizeof(ps_info), 1, fp) > 0) {
    temp = malloc(sizeof(PROCESS_STRUCT));
    temp->next = NULL;

    sprintf(temp->pid, "%u", ps_info.pr_pid);
    strcpy(temp->name, ps_info.pr_fname);
    temp->jiffies = ps_info.pr_time.tv_sec * 100;
  }

  fclose(fp);

  return(temp);
}

/*
** Return true if name is all digits (indicates process directory)
*/
int test_file_name(char *arg) {
  while(*arg != 0) {
    if (isdigit(*arg++)) {
      //empty
    } else {
      return(0);
    }
  }

  return(1);
}

/*
** Inspect the /proc directory for process directories
*/
PROCESS_STRUCT *proc_driver() {
  DIR *dp;
  struct dirent *dir;
  PROCESS_STRUCT *current, *root;

  root = NULL;
  current = NULL;

  if ((dp = opendir("/proc")) == NULL) {
    fprintf(stderr, "open failure\n");
    exit(1);
  }

  while ((dir = readdir(dp)) != NULL) {
    if (dir->d_ino == 0) {
      continue;
    }

    if (test_file_name(dir->d_name)) {
      if (root == NULL) {
        root = current = read_datum(dir->d_name);
      } else {
        current->next = read_datum(dir->d_name);
        if (current->next != NULL) {
          current = current->next;
        }
      }
    }
  }

  closedir(dp);

  return(root);
}

/*
**
*/
JNIEXPORT jstring JNICALL Java_com_bgi_essa_jboss4_jmx_JniStub_getProcesses(JNIEnv *env, jobject arg) {
  char buffer1[64];
  char buffer2[65536];
  PROCESS_STRUCT *current, *root;
  jstring result;

  strcpy(buffer2, "\0");

  root = proc_driver();
  while (root != NULL) {
    sprintf(buffer1, ":%s %s %lu:", root->pid, root->name, root->jiffies);
    strcat(buffer2, buffer1);

    current = root;
    root = root->next;
    free(current);
  }

  result = (*env)->NewStringUTF(env, buffer2);
  return(result);
}
