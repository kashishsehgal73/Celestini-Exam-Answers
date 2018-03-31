import glob
import errno
import csv
import random
import csv
import simpleSubCipher
import vigenereCipher
LETTERS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
def getLetterCount(message):
    message = message.upper()
    # Makes a dictionary with keys of single letters and values of the
    # count of how many times they appear in the message parameter.
    count  = 0
    letterToCount = {}
    sor = []
    for letter in LETTERS:
        letterToCount[letter] = 0 # intialize each letter to 0

    for letter in message:
        if letter in LETTERS:
            count +=1
            letterToCount[letter] += 1


    for key  in letterToCount:
        sor.append((letterToCount[key]))
    sor.sort(reverse=True)
    return sor

path = '/home/kashishsehgal73/Downloads/DataGenerate/datastrings/*.txt'
files = glob.glob(path)
cntt = 0
mydata = []
header  = ['Message','Encrypt','1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20','21','22','23','24','25','26','Result']
mydata.append(header)

def cleanstr(s):
    s = s.replace("<br /><br />", '')
    a = ''.join([i for i in s if i.isalpha() or i == ' '])
    a = a[:200]
    a.upper()
    return a


for name in files:
    cntt += 1
    try:
        with open(name) as f:
            temp = []
            s = (f.read())
            a= cleanstr(s)


            if cntt < 200:
                key = simpleSubCipher.getRandomKey()
                translated = simpleSubCipher.encryptMessage(key, a)
                fc = getLetterCount(a)
                temp.append(a.upper())
                temp.append(translated.upper())
                for i in fc:
                    temp.append(i)
                temp.append(0)
                mydata.append(temp)


            if cntt > 200 and cntt < 400:
                key = vigenereCipher.getRandomKey()
                translated = vigenereCipher.encryptMessage(key, a)
                fc = getLetterCount(a)
                temp.append(a.upper())
                temp.append(translated.upper())
                for i in fc:
                    temp.append(i)
                temp.append(1)
                mydata.append(temp)

    except IOError as exc:
        if exc.errno != errno.EISDIR:
            pass

myFile = open('data.csv', 'w')
with myFile:
    writer = csv.writer(myFile)
    writer.writerows(mydata)
