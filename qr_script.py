import pyqrcode


def generate_qr():
    link_to_post = "1"
    url = pyqrcode.create(link_to_post)
    url.png('url.png', scale=8)
    print("Printing QR code")
    print(url.terminal())


if __name__ == '__main__':
    generate_qr()
    big_code = pyqrcode.create('0987654321', error='L', version=27, mode='binary')
    big_code.png('code.png', scale=6, module_color=[0, 0, 0, 0], background=[0xff, 0xff, 0xcc])
