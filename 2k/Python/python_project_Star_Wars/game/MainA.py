from socket import socket

import pygame, time
from game import Configure
from game.Bullet import Bullet
from game.PlayerA import PlayerA
from game.PlayerB import PlayerB
from game.Target import Target

DISPLAY = (Configure.WIN_WIDTH, Configure.WIN_HEIGHT)
BACKGROUND_COLOR = Configure.BACKGROUND_COLOR
TITLE = Configure.TITLE


def printMessage(screen, myfont):


    textsurface = myfont.render('Game over', False, pygame.Color("#ffffff"), )
    screen.blit(textsurface, (Configure.WIN_WIDTH // 2 - 100, Configure.WIN_HEIGHT // 2))
    pygame.display.update()
    pygame.time.wait(5000)
    raise SystemExit


def send(c, dx, dy, direction, target, hp, my_bullets, other_players, other_bullets, screen=None, myfont=None):
    other_bullets.clear()

    data = c.recv(1234)
    if not data:
        printMessage(screen, myfont)
    print(data.decode("utf-8"))
    data_array = data.split()
    other_players[0].update(int(data_array[0]), int(data_array[1]), data_array[2].decode("utf-8"))
    target.hp = min(target.hp, int(data_array[3]))
    other_players[0].hp = bool(data_array[4])
    for i in range(5, len(data_array), 3):
        other_bullets.append(Bullet(int(data_array[i]), int(data_array[i + 1]), data_array[i + 2]))

    data = [dx, dy, direction, target.hp, hp]
    for b in my_bullets:
        data.append(b.x)
        data.append(b.y)
        data.append(b.direction)
    if not data:
        printMessage(screen, myfont)
    c.send(bytes(" ".join([str(i) for i in data]), encoding="utf-8"))

# Настройка звука
pygame.mixer.pre_init(44100, -16, 1, 512)
pygame.mixer.init()
sound = pygame.mixer.Sound("sounds/Fight.ogg")
sound.play()

def main():
    move_delay = time.time()
    bullet_create_delay = time.time()

    pygame.init()
    pygame.font.init()
    myfont = pygame.font.SysFont('Comic Sans MS', 30)

    screen = pygame.display.set_mode(DISPLAY)
    pygame.display.set_caption(TITLE)
    bg = pygame.Surface(DISPLAY)
    bg.fill(BACKGROUND_COLOR)

    me = PlayerA(100, Configure.WIN_HEIGHT - 100)
    direction = "U"
    target = Target()
    my_bullets = []

    other_bullets = []
    other_players = [PlayerB(100, 100)]

    go = True

    HOST = Configure.HOST
    PORT = Configure.PORT
    ADDR = (HOST, PORT)

    c = socket()
    c.settimeout(3.0)
    c.connect(ADDR)

    while go:  # Основной цикл программы
        screen.blit(bg, (0, 0))

        for e in pygame.event.get():
            if e.type == pygame.QUIT or pygame.key.get_pressed()[pygame.K_ESCAPE]:
                raise SystemExit("QUIT")

        dx = 0
        dy = 0
        if time.time() - move_delay > 0.005:
            move_delay = time.time()
            if (pygame.key.get_pressed()[pygame.K_UP]):
                dy = -1
            if (pygame.key.get_pressed()[pygame.K_DOWN]):
                dy = 1
            if (pygame.key.get_pressed()[pygame.K_LEFT]):
                dx = -1
            if (pygame.key.get_pressed()[pygame.K_RIGHT]):
                dx = 1

            if (pygame.key.get_pressed()[pygame.K_1]):
                direction = "U"
            if (pygame.key.get_pressed()[pygame.K_2]):
                direction = "R"
            if (pygame.key.get_pressed()[pygame.K_3]):
                direction = "D"
            if (pygame.key.get_pressed()[pygame.K_4]):
                direction = "L"

            send(c, dx, dy, direction, target, me.hp, my_bullets, other_players, other_bullets, screen, myfont)

        if time.time() - bullet_create_delay > 0.3:
            bullet_create_delay = time.time()
            if (pygame.key.get_pressed()[pygame.K_SPACE]):
                my_bullets.append(me.shoot(direction))

        for elem in my_bullets:
            elem.update(my_bullets)
            elem.draw(screen)

        for elem in other_bullets:
            elem.draw(screen)

        for elem in other_players:
            elem.draw(screen)

        me.update(dx, dy, direction)
        me.draw(screen)
        target.draw(screen, pygame)

        flag = target.сollision_detection(my_bullets, other_players, me)

        if flag:
            send(c, dx, dy, direction, target, me.hp, my_bullets, other_players, other_bullets, screen, myfont)
            screen.blit(bg, (0, 0))
            printMessage(screen, myfont)

        pygame.display.update()


if __name__ == "__main__":
    main()
