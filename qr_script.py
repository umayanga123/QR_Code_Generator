import pyqrcode
import Crypto
from Crypto.PublicKey import RSA
from Crypto.Hash import SHA256
from Crypto.Signature import pss
import base64

def generate_qr(tag ,data):
    signature = sign(data)
    data_Set = str(tag) +","+ str(data) +"," + str(signature)
    url = pyqrcode.create(data_Set)
    url.png('url.png', scale=8)
    print("Print QR code")
    print(data_Set)

def sign(data):
    private_key = RSA.import_key(open('key/private.pem').read())
    h = SHA256.new(data)
    signature =  base64.b64encode(pss.new(private_key).sign(h))
    print("signature generate")
    verify(data,signature)
    return signature
   

def verify(recive_Data ,signature):
    public_key = RSA.import_key(open('key/receiver.pem').read())
    h =  SHA256.new(recive_Data)
    verifier = pss.new(public_key)
    try:
        verifier.verify(h, base64.b64decode(signature))
        print("The signature is authentic")
    except (ValueError, TypeError):
        print ("The signature is not authentic.")


if __name__ == '__main__':
    generate_qr(b'S1',b'www.google.com')
    print("QR code successfully Generated")

