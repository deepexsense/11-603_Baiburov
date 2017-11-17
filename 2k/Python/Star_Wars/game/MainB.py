import pygame, time
from game import Configure
from game.Bullet import Bullet
from game.PlayerA import PlayerA
from game.PlayerB import PlayerB
from game.Target import Target
from socket import *

DISPLAY = (Configure.WIN_WIDTH, Configure.WIN_HEIGHT)
BACKGROUND_COLOR = Configure.BACKGROUND_COLOR
TITLE = Configure.TITLE


def send(c, s, dx, dy, direction, target, hp, my_bullets, other_players, other_bullets, screen=None, myfont=None):
    data = [dx, dy, direction, target.hp, hp]
    for b in my_bullets:
        data.append(b.x)
        data.append(b.y)
        data.append(b.direction)
    c.send(bytes(" ".join([str(i) for i in data]), encoding="utf-8"))

    other_bullets.clear()

    data = c.recv(1024)
    if not data:
        c.close()
        s.close()
    print(data.decode("utf-8"))

    data_array = data.split()
    other_players[0].update(int(data_array[0]), int(data_array[1]), data_array[2].decode("utf-8"))
    target.hp = min(target.hp, int(data_array[3]))
    other_players[0].hp = bool(data_array[4])
    for i in range(5, len(data_array), 3):
        other_bullets.append(Bullet(int(data_array[i]), int(data_array[i + 1]), data_array[i + 2]))


def printMessage(screen, myfont):

    textsurface = myfont.render('Game over', False, pygame.Color("#ffffff"))
    screen.blit(textsurface, (Configure.WIN_WIDTH // 2 - 100, Configure.WIN_HEIGHT // 2))
    pygame.display.update()
    pygame.time.wait(5000)
    raise SystemExit

#Настройка звука
#pygame.mixer.pre_init(44100, -16, 1, 512)
#pygame.mixer.init()
#sound = pygame.mixer.Sound("sounds/Fight.ogg")
#sound.play()


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

    me = PlayerB(100, 100)
    direction = "U"
    target = Target()
    my_bullets = []
    other_bullets = []
    other_players = [PlayerA(100, Configure.WIN_WIDTH - 100)]

    HOST = ''
    PORT = Configure.PORT
    ADDR = (HOST, PORT)

    s = socket()
    s.bind(ADDR)
    s.listen(2)
    c, addr = s.accept()
    go = True
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
            send(c, s, dx, dy, direction, target, me.hp, my_bullets, other_players, other_bullets, screen, myfont)

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
            send(c, s, dx, dy, direction, target, me.hp, my_bullets, other_players, other_bullets, screen, myfont)
            screen.blit(bg, (0, 0))
            printMessage(screen, myfont)
        pygame.display.update()

    def set(self, x, y):
        self.rect.x = x
        self.rect.y = y


class Menu:
    def __init__(self, items = [120, 140, u'=Item', (250, 250, 30), (250, 30, 250), 0]):
        self.items = items
    def draw_items(self, background, font, item_number):
        for i in self.items:
            if item_number == i[5]:
                background.blit(font.draw_items(i[2], 1, i[4]), (i[0], i[1]))
            else:
                background.blit(font.draw_items(i[2], 1, i[3]), (i[0], i[1]))
    def menu(self):
        done = True
        self.font_menu = pygame.font.init()
        font_menu = pygame.font.Font("fonts/STARWARS.OTF", 50)
        item = 0
        while done:
            main().screen.fill((0, 100, 200))

            mp = pygame.mouse.get_pos()
            for i in self.items:
                if mp[0] > i[0] and mp[0] < i[0] + 155 and mp[1] > i[1] and mp[1] < i[1] + 50:
                    item = i[5]
            self.draw_items(main().screen, font_menu, item)

            for e in pygame.event.get():
                if e.type == pygame.QUIT:
                    raise SystemExit("QUIT")
                if  e.type == pygame.KEYDOWN:
                    if e.key == pygame.K_ESCAPE:
                        raise SystemExit("QUIT")
                    if e.key == pygame.K_UP:
                        if item > 0:
                            item = -1
                    if e.key == pygame.K_DOWN:
                        if item < len(self.items)-1:
                            item += 1
                if e.type == pygame.MOUSEBUTTONDOWN and e.button == 1:
                    if item == 0:
                        done = False
                    elif item == 1:
                        raise SystemExit("QUIT")


            main().bg.blit(main().screen, (0,0))
            pygame.display.flip()

items = [(120, 140, u'=Game', (250, 250, 30), (250, 30, 250), 0),
         (130, 210, u'=Quit', (250, 250, 30), (250, 30, 250), 1)]
game = Menu(items)
game.menu()

if __name__ == "__main__":
    main()
