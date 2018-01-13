import socket
import sys

def Tcp_Write(D):
   s.send(D + '\r')
   return 
   
def Tcp_Read( ):
	a = ' '
	b = ''
	while a != '\r':
		a = s.recv(1)
		b = b + a
	return b



HOST = '' #this is your localhost
PORT = 12345 

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((HOST,PORT)) #IP is the server IP
 
for args in sys.argv:
    if args == "":
        args = 'no args'
    else:
        s.send(args + ' ')

s.send(args + ' ')
Tcp_Write('hello')

print Tcp_Read()
print 'goodbye!'