# -*- coding: utf-8 -*-
# Generated by Django 1.11.3 on 2018-02-12 15:08
from __future__ import unicode_literals

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Message',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('text', models.TextField()),
                ('pub_date', models.DateTimeField(auto_now=True)),
                ('reply_to', models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, to='chan_m.Message')),
            ],
            options={
                'verbose_name': 'Сообщение',
                'verbose_name_plural': 'Сообщения',
                'db_table': 'msgs',
            },
        ),
    ]
