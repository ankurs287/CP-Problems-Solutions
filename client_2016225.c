#include <stdio.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <netdb.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <arpa/inet.h> 

#define PORT 5555

int main(int argc, char *argv[])
{
    int sock = 0;
    struct sockaddr_in serv_addr; 

    if(argc != 2)
    {
        printf("\n Usage: %s <Server IP address>\n",argv[0]);
        return -1;
    } 
    if((sock = socket(AF_INET, SOCK_STREAM, 0)) < 0)
    {
        printf("\n Something went wrong in socket creation \n");
        return -1;
    } 
    memset(&serv_addr, '\0', sizeof(serv_addr)); 

    serv_addr.sin_family = AF_INET;
    serv_addr.sin_port = htons(PORT); 

    if(inet_pton(AF_INET, argv[1], &serv_addr.sin_addr)<=0) 
    {
        printf("\nInvalid address/ Address not supported \n");
        return -1;
    } 

    if( connect(sock, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0)
    {
       printf("\nConnection Failed \n");
       return -1;
    } 

    int readbytes = 0;
    char recvBuff[500];
    char sendBuff[500];
    memset(recvBuff, '\0',sizeof(recvBuff));
    memset(sendBuff, '\0',sizeof(sendBuff));
    printf("ENTER YOUR REQUEST\n");
    printf("=================================================================\n");
    fgets(sendBuff,sizeof(sendBuff),stdin);
    printf("=================================================================\n");
    int writebytes=write(sock,sendBuff,sizeof(sendBuff));
    if(writebytes < 0)
    {
        printf("\n ERROR, in writing to socket\n");
    }

    readbytes = read(sock,recvBuff,sizeof(recvBuff));
    if(readbytes < 0)
    {
        printf("\n Read error \n");
    }
    printf("REPLY FROM SERVER\n\n"); 
    printf("%s\n",recvBuff );
    printf("=================================================================\n");
    return 0;
}
