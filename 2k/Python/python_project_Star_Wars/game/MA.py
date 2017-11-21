import time

from game.MainA import MainA

while True:
    instance = MainA()
    c = instance.waiting()
    instance.main(c)
    c.close()
    time.sleep(1)
    instance = None