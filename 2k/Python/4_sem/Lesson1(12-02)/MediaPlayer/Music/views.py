from django.http import HttpResponse
from django.shortcuts import render

# Create your views here.
from Music.models import Country, Artist, City


def query(request):
    #q = Artist.objects.filter(year_start=1983)
    #q = Country.objects.all()
    c = City.objects.get(name="St.Petersburg")
    q = Artist.objects.filter(city_id=c.id)
    lst = q.values_list("name")
    return HttpResponse(lst)