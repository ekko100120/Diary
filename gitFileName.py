#-*- coding:utf-8 -*-
#author:ekko
#date:2016/11/20
import os 

def getFileName(filename):
	(filepath, tempfile)= os.path.split(filename)
	(shotname, extension)= os.path.splitext(tempfile)
	over= extension.strip('.')
	mylist= filepath.split('/')
	return mylist, filepath, shotname, extension, over

filename='/home/ekko/PycharmProjects/mySocket/mySocket/mk.py'
print gitFileName(filename)
