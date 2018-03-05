from django.contrib.auth.models import User
from django.db import models

# Create your models here.


class Country(models.Model):
    name = models.CharField(max_length=30)

class City(models.Model):
    name = models.CharField(max_length=30)
    country = models.ForeignKey(Country)

class Artist(models.Model):
    name = models.CharField(max_length=30)
    city = models.ForeignKey(City)
    year_start = models.PositiveSmallIntegerField()
    year_end = models.PositiveSmallIntegerField()


class Audio(models.Model):
    title = models.CharField(max_length=30)
    artist = models.ForeignKey(Artist, related_name="audios")
    year = models.PositiveSmallIntegerField()
    duration = models.DurationField()

class Playlists(models.Model):
    audios = models.ManyToManyField(Audio)
    user = models.ForeignKey(User)
    pl_name = models.CharField(max_length=20)
    liked = models.ManyToManyField(User, through="Likes", related_name="like")

class Likes(models.Model):
    user = models.ForeignKey(User)
    playlist = models.ForeignKey(Playlists)
    when = models.DateTimeField

    def __unicode__(self):
        return self.playlist + ": " + self.user.username