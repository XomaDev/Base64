# Base64

A simple Base64 encoder made for learning purpose. This could be done using in-built Base64 encoder too. Code Written by Kumaraswamy B G.


### HOW TO

This may not support certain characters like non - ASCII characters.
<br>

Intialize the encoder with the input bytes:
<br>

```
Base64Encoder base64Encoder = new Base64Encoder(text.getBytes());
```

<br>

And to encode to Base64 string :
<br>

```
base64Encoder.convert();
```

<br>

Thanks to the article : https://pthree.org/2011/04/06/convert-text-to-base-64-by-hand
