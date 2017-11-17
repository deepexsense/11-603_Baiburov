from pygame import *

WIN_WIDTH = 1200
WIN_HEIGHT = 700

class Bullet:
    def __init__(self, x, y, d):
        self.x = x
        self.y = y
        self.r = 5
        self.direction = d
        self.color = Color("#004DFF")

    def update(self, bullets):
        if self.x <= 0 or self.y <= 0 or self.x >= WIN_WIDTH or self.y >= WIN_HEIGHT:
            bullets.remove(self)
        elif self.direction == "U":
            self.y -= 8
        elif self.direction == "D":
            self.y += 8
        elif self.direction == "L":
            self.x -= 8
        else:
            self.x += 8

    def draw(self, screen):
        draw.circle(screen, self.color, (self.x, self.y), self.r, 0)
