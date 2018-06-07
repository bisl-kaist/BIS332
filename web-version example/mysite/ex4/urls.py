from django.urls import path

from . import views

app_name = 'ex4'
urlpatterns = [
   path('', views.intro, name = 'intro_page'),
   path('check/', views.login_check, name = 'login_check'),
   path('query/', views.query, name = 'query'),
   path('query/result/', views.result, name = 'query_result'),
#   path('test/', views.askSpringBoot),
]
