from pygame import *

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
        font_menu = pygame.font.Font("fonts/STARWARS.TTF", 50)
        item = 0
        while done:
            screen.fill((0, 100, 200))

items = [(120, 140, u'=Game', (250, 250, 30), (250, 30, 250), 0),
         (130, 210, u'=Quit', (250, 250, 30), (250, 30, 250), 1)]
game = Menu(items)

