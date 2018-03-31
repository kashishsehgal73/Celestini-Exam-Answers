from sklearn import cross_validation
import pandas as pd
from sklearn.svm import SVC

LETTERS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
def getLetterCount(message):
    message = message.upper()
    # Returns a dictionary with keys of single letters and values of the
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
        sor.append(letterToCount[key])
    sor.sort(reverse=True)
    #print(letterToCount)

    #print(sum(sor))
    return sor


myFile = 'data.csv'
df = pd.read_csv(myFile)
test_X = df['Encrypt']
test_Y = df['Result']

X = []
for i in range(len(test_X)):
	X.append(getLetterCount(test_X[i]))


X_train, X_test , y_train , y_test = cross_validation.train_test_split(X,test_Y,test_size=0.2)
from sklearn.neural_network import MLPClassifier
clf = MLPClassifier(solver='lbfgs', alpha=1e-5, hidden_layer_sizes=(5, 5),activation='logistic')

clf.fit(X_train,y_train)
accuracy = clf.score(X_test,y_test)
print(accuracy)
