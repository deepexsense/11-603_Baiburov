from django.contrib import admin

# Register your models here.

from django.contrib import admin

from .models import Country, City, Artist, Audio, Playlists, Likes

admin.site.register(Country)
admin.site.register(City)
admin.site.register(Artist)
admin.site.register(Audio)
admin.site.register(Playlists)
admin.site.register(Likes)