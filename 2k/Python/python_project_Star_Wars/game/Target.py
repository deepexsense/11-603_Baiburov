from math import sqrt
from pygame import sprite, Surface, Color, image, transform
from pygame.rect import Rect

from game import Configure
from game.Bullet import Bullet
from game.Configure import ME_SIZE

TARGET_SIZE = Configure.TARGET_SIZE
WIN_WIDTH = Configure.WIN_WIDTH
WIN_HEIGHT = Configure.WIN_HEIGHT


class Target(sprite.Sprite):
    def __init__(self):
        sprite.Sprite.__init__(self)
        x = WIN_WIDTH // 2
        y = WIN_HEIGHT // 2

        self.image = image.load("sprites/grey.png")
        self.image = transform.scale(self.image, (TARGET_SIZE, TARGET_SIZE))
        self.rect = Rect(x - TARGET_SIZE // 2, y - TARGET_SIZE // 2, TARGET_SIZE, TARGET_SIZE)

        self.y0 = self.rect.y + TARGET_SIZE // 2
        self.x0 = self.rect.x + TARGET_SIZE // 2
        self.hp = 99

    def update(self, dx, dy):
        if ((self.rect.x + TARGET_SIZE < WIN_WIDTH - 1 and dx >= 0 or self.rect.x > 1 and dx <= 0) and
                (self.rect.y + TARGET_SIZE < WIN_HEIGHT - 1 and dy >= 0 or self.rect.y > 1 and dy <= 0)):
            self.rect.x += dx
            self.rect.y += dy
            self.y0 = self.rect.y + TARGET_SIZE // 2
            self.x0 = self.rect.x + TARGET_SIZE // 2

    def shoot(self, direction):
        bullet = Bullet(self.x0, self.y0, "U")
        return bullet

    def draw(self, screen, pygame):
        if self.hp > 0:
            screen.blit(self.image, (self.rect.x, self.rect.y))
            pygame.draw.line(screen, Color("#fafafa"), (10, 10), (self.hp + 10, 10), 10)
        else:
            self.update(- 1000, -1000)

    def сollision_detection(self, bullets, enemies, me):
        flag = False
        for bullet in bullets:
            for enemy in enemies:
                if sqrt((bullet.x - enemy.x0) ** 2 + (bullet.y - enemy.y0) ** 2) <= (bullet.r + ME_SIZE) // 2:
                    self.killElem(bullets, bullet)
                    self.killElem(enemies, enemy)
                    flag = True


            if sqrt((bullet.x - self.x0) ** 2 + (bullet.y - self.y0) ** 2) <= (TARGET_SIZE + bullet.r) // 2:
                self.hp -= 10
                self.killElem(bullets, bullet)
                if self.hp <= 0:
                    flag = True


            if sqrt((bullet.x - me.x0) ** 2 + (bullet.y - me.y0) ** 2) <= (bullet.r + ME_SIZE) // 2:
                me.hp = False
                self.killElem(bullets, bullet)
                flag = True


        for enemy in enemies:
            if sqrt((enemy.x0 - me.x0) ** 2 + (enemy.y0 - me.y0) ** 2) <= ME_SIZE:
                me.hp = False
                flag = True


        if sqrt((self.x0 - me.x0) ** 2 + (self.y0 - me.y0) ** 2) <= (ME_SIZE + TARGET_SIZE) // 2:
            me.hp = False
            flag = True
        return flag


    def killElem(self, container, elem):
        try:
            elem.hp = False
        except:
            elem.x = -2000
            elem.y = - 2000
        container.remove(elem)
