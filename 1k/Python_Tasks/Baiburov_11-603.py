if __name__ == '__main__': 
	file = open("table.html", 'w', encoding="utf-8") 
	file.write('<table border=10><tr><th><i style="color:red"> </i></th>') 
	for i in range(1,11): 
		file.write('<th style="font-size:30px">'+str(i)+"</th>") 
	file.write("</tr>") 
	for i in range(1, 11): 
		file.write("<tr><th style=\"font-size:30px\">"+str(i)+"</th>") 
		for j in range(1, 11): 
			file.write("<th>"+str(i * j)+"</th>") 
		file.write("</tr>") 
	file.write("</table>") 
	file.close()
	print("success") 
