from Crypto.PublicKey import RSA

print("--Private Key Generate--")

key = RSA.generate(2048)
private_key = key.export_key()
file_out = open("key/private.pem", "wb")
file_out.write(private_key)
file_out.close()

print("--Public Key Generate--")

public_key = key.publickey().export_key()
file_out_1 = open("key/receiver.pem", "wb")
file_out_1.write(public_key)
file_out_1.close()

print("key Generated")
