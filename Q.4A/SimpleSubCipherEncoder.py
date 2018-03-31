import random


LETTERS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'

def encryptMessage(key, message):
    return translateMessage(key, message, 'encrypt')



def translateMessage(key, message, mode):
    translated = ''
    charsA = LETTERS
    charsB = key

    # loop through each symbol in the message
    for symbol in message:
        if symbol.upper() in charsA:
            # encrypt/decrypt the symbol
            symIndex = charsA.find(symbol.upper())
            if symbol.isupper():
                translated += charsB[symIndex].upper()
            else:
                translated += charsB[symIndex].lower()
        else:
            # symbol is not in LETTERS, just add it
            translated += symbol

    return translated.upper()


def getRandomKey():
    key = list(LETTERS)
    random.shuffle(key)
    return ''.join(key)
