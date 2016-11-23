#define WIN32_LEAN_AND_MEAN

#include <stdio.h>
#include <windows.h>

void monitorDiskSpace ( const char directory[] )
{
    ULARGE_INTEGER free_bytes_available;
    ULARGE_INTEGER total_number_bytes;
    ULARGE_INTEGER total_number_free_bytes;

    BOOL result = GetDiskFreeSpaceEx ( directory, &free_bytes_available, &total_number_bytes, &total_number_free_bytes );

    if ( result > 0 )
    {
        printf ( "Directory: %s\n",                   directory               );
        printf ( "\t%I64d bytes available\n",         free_bytes_available    );
        printf ( "\t%I64d number bytes total\n",      total_number_bytes      );
        printf ( "\t%I64d total number free bytes\n", total_number_free_bytes );
    }
}

void main ()
{
    monitorDiskSpace ( "c:\\" );
}
