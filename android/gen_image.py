import string
import random
import os
from PIL import Image

prefix = 'pflbs_app_'
path = r'res_pflbs/res/mipmap-xxxhdpi/'
def get_name():
   return  ''.join(random.sample(['0','1','2','3','4','5','6','7','8','9','z','y','x','w','v','u','t','s','r','q','p','o','n','m','l','k','j','i','h','g','f','e','d','c','b','a'],5))
def gen_mipmap():
    image = Image.new('RGB', (random.randint(1, 512), random.randint(1, 512)))
    # image = image.resize((1, 1))  # 更改图片的大小为800x600像素
    ri = random.randint(1,2)
    if(ri==1):
        image = image.convert('RGBA')
    image.save(path+(prefix+get_name()+'.png').lower(), 'PNG')
if (os.path.exists(path)==False):
    os.makedirs(path)
for _ in range(0,10000):
    gen_mipmap()
