# -*- coding: utf-8 -*-
from __future__ import unicode_literals

import datetime
from django.contrib.auth.models import User
from django.db import models


class Message(models.Model): # chan_messages
    """ Messages of our chan """
    class Meta:
        verbose_name = u"Сообщение"
        verbose_name_plural = u"Сообщения"
        db_table = "msgs"

    text = models.TextField()
    pub_date = models.DateTimeField(auto_now=True)
    reply_to = models.ForeignKey("Message", null=True) # (self)

    def __unicode__(self):
        return self.text

