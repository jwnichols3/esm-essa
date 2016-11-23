/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class Poller */

#ifndef _Included_Poller
#define _Included_Poller
#ifdef __cplusplus
extern "C" {
#endif
#undef Poller_POLLERR
#define Poller_POLLERR 8L
#undef Poller_POLLHUP
#define Poller_POLLHUP 16L
#undef Poller_POLLNVAL
#define Poller_POLLNVAL 32L
#undef Poller_POLLIN
#define Poller_POLLIN 1L
#undef Poller_POLLPRI
#define Poller_POLLPRI 2L
#undef Poller_POLLOUT
#define Poller_POLLOUT 4L
#undef Poller_POLLRDNORM
#define Poller_POLLRDNORM 64L
#undef Poller_POLLWRNORM
#define Poller_POLLWRNORM 4L
#undef Poller_POLLRDBAND
#define Poller_POLLRDBAND 128L
#undef Poller_POLLWRBAND
#define Poller_POLLWRBAND 256L
#undef Poller_POLLNORM
#define Poller_POLLNORM 64L
/*
 * Class:     Poller
 * Method:    nativeInit
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_Poller_nativeInit
  (JNIEnv *, jclass);

/*
 * Class:     Poller
 * Method:    nativeCreatePoller
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_Poller_nativeCreatePoller
  (JNIEnv *, jobject, jint);

/*
 * Class:     Poller
 * Method:    nativeDestroyPoller
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_Poller_nativeDestroyPoller
  (JNIEnv *, jobject, jint);

/*
 * Class:     Poller
 * Method:    nativeAddFd
 * Signature: (IIS)I
 */
JNIEXPORT jint JNICALL Java_Poller_nativeAddFd
  (JNIEnv *, jobject, jint, jint, jshort);

/*
 * Class:     Poller
 * Method:    nativeRemoveFd
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_Poller_nativeRemoveFd
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     Poller
 * Method:    nativeRemoveIndex
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_Poller_nativeRemoveIndex
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     Poller
 * Method:    nativeIsMember
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_Poller_nativeIsMember
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     Poller
 * Method:    nativeWait
 * Signature: (II[I[SJ)I
 */
JNIEXPORT jint JNICALL Java_Poller_nativeWait
  (JNIEnv *, jobject, jint, jint, jintArray, jshortArray, jlong);

/*
 * Class:     Poller
 * Method:    getNumCPUs
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_Poller_getNumCPUs
  (JNIEnv *, jclass);

#ifdef __cplusplus
}
#endif
#endif
