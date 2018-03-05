# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.http import HttpResponse
from django.shortcuts import render

from chan.models import Message


def show_messages(request):
    messages = Message.objects.all()

    return render(request, "chan/show_messages.html",
    {"messages": messages})

def reply(request, message_id):
    return render(request,
                  "chan/reply.html",
                  {"msg_id": message_id}
    )