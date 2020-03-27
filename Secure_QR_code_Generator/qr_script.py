import sys
import pyqrcode

def generate_qr(data ,tag):
    url = pyqrcode.create(data)
    url.png("qr\\"+tag+""+'.png', scale=8)
    print("Print QR code")
    print(data)

if __name__ == '__main__':
    generate_qr(sys.argv[1] , sys.argv[2])
    print("QR code successfully Generated")

