'''
    * 
   * * 
  * * * 
 * * * * 
* * * * * 
 * * * * 
  * * * 
   * * 
    * 
'''

s=4
e=1
for i in range (4):
    for j in range (s):
        print(end=" ")
    for j in range (e):
        print(end="* ")
    s=s-1
    e=e+1
    print()
s=0
e=5
for i in range (5):
    for j in range (s):
        print(end=" ")
    for j in range (e):
        print(end="* ")
    s=s+1
    e=e-1
    print()