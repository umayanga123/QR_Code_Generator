import sys
import pyqrcode

def generate_qr(data):
    url = pyqrcode.create(data)
    url.png('url.png', scale=8)
    print("Print QR code")
    print(data)

if __name__ == '__main__':
    generate_qr(sys.argv[1])
    print("QR code successfully Generated")

