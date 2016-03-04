import os
from shell import ShellCommand as cmd;

def fazCommit():
    cmd.run_command('git add *',"")
    cmd.run_command('git commit -m "automatic commit"','')
    cmd.run_command('git push origin master','')

def listaDeDiretorios(path):
    return os.listdir(path)

def percorreDiretorios(path):
    dirs = listaDeDiretorios(path)
    for dirName in dirs:
        if(os.path.isdir(path + dirName)):
            os.chdir(path + dirName)
            print('entrando no diretorio' + os.path.realpath(dirName))
            if os.path.isdir('.git'):
                print('fazendo commit de ' + os.path.realpath(dirName))
                fazCommit();
