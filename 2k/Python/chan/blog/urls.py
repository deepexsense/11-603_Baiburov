from django.conf.urls import url

from blog.views import PostsListView, PostsDetailsView

urlpatterns=[
                url(r'^$', PostsListView.as_view(), name = 'list'),
                url(r'^(?P<pk>\d+)/$', PostsDetailsView.as_view()),
            ]