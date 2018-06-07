from django.shortcuts import render
from django.shortcuts import redirect
import requests
from django.http import HttpResponse, JsonResponse
#from django.template.loader import render_to_string


# Create your views here.

def intro(request):
    return render(request, 'ex4/intro.html')

def login_check(request):
    idInput = request.POST.get('user_id')
    print (idInput)
    return render(request, 'ex4/check.html', {'user_id': idInput})

def query(request):
    return render(request, 'ex4/query.html')

def result(request):
    student_id = request.POST.get('query_id')
    url = 'http://biostar.kaist.ac.kr:8103/restSelectorResult?inputNo=' + str(student_id)
    response = requests.get(url)
    result = response.json()
    print(result)
 
    context = {'result_list': result, 'input': student_id}
    return render(request, 'ex4/result.html', context)


