from subprocess import call

def run_command(cmd,params):
    if not params:
        call(cmd, shell=True)
    else:
        call(cmd + params, shell=True)
        