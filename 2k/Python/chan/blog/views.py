from django.http import HttpResponse
from django.shortcuts import render

# Create your views here.
from django.views.generic import ListView, DetailView

from blog.models import Post


class PostsListView(ListView):
    model = Post

class PostsDetailsView(DetailView):
    model = Post
