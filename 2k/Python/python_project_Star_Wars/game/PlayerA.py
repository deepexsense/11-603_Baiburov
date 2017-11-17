from pygame import sprite, Surface, image, transform, mixer
from pygame.rect import Rect
from game import Configure
from game.Bullet import Bullet

ME_SIZE = Configure.ME_SIZE
WIN_WIDTH = Configure.WIN_WIDTH
WIN_HEIGHT = Configure.WIN_HEIGHT

mixer.pre_init(44100, -16, 1, 512)
mixer.init()

class PlayerA(sprite.Sprite):
    def __init__(self, x, y):
        sprite.Sprite.__init__(self)

        self.image_u = image.load("sprites/red-u.png")
        self.image_r = image.load("sprites/red-r.png")
        self.image_l = image.load("sprites/red-l.png")
        self.image_d = image.load("sprites/red-d.png")

        self.image_u = transform.scale(self.image_u, (ME_SIZE, ME_SIZE))
        self.image_r = transform.scale(self.image_r, (ME_SIZE, ME_SIZE))
        self.image_l = transform.scale(self.image_l, (ME_SIZE, ME_SIZE))
        self.image_d = transform.scale(self.image_d, (ME_SIZE, ME_SIZE))

        self.image = self.image_u

        self.rect = Rect(x, y, ME_SIZE, ME_SIZE)
        self.y0 = self.rect.y + ME_SIZE // 2
        self.x0 = self.rect.x + ME_SIZE // 2

        self.hp = True

    def update(self, dx, dy, direction):
        if ((self.rect.x + ME_SIZE < WIN_WIDTH - 1 and dx >= 0 or self.rect.x > 1 and dx <= 0) and
                (self.rect.y + ME_SIZE < WIN_HEIGHT - 1 and dy >= 0 or self.rect.y > 1 and dy <= 0)):
            self.rect.x += dx * 2
            self.rect.y += dy * 2
            self.y0 = self.rect.y + ME_SIZE // 2
            self.x0 = self.rect.x + ME_SIZE // 2

            if direction == "U":
                self.image = self.image_u
            elif direction == "D":
                self.image = self.image_d

            elif direction == "L":
                self.image = self.image_l
            else:
                self.image = self.image_r

    def shoot(self, direction):
        x = self.x0
        y = self.y0
        r = Configure.BULLET_R
        if direction == "U":
            y -= ME_SIZE // 2 + r + 1
        elif direction == "D":
            y += ME_SIZE // 2 + r + 1

        elif direction == "L":
            x -= ME_SIZE // 2 + r + 1
        else:
            x += ME_SIZE // 2 + r + 1

        bullet = Bullet(x, y, direction)
        self.shot_sound = mixer.Sound("sounds/Shot.ogg")
        self.shot_sound.play()
        return bullet

    def draw(self, screen):
        screen.blit(self.image, (self.rect.x, self.rect.y))
