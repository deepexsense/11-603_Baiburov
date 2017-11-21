import time

from game.MainB import MainB

while True:
    instanse = MainB()
    c, s, flag = instanse.waiting()
    if flag:
        break
    instanse.main(c, s)
    s.close()
    c.close()
    instance = None