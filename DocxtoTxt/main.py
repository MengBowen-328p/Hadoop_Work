# 这是一个示例 Python 脚本。

# 按 Shift+F10 执行或将其替换为您的代码。
# 按 双击 Shift 在所有地方搜索类、文件、工具窗口、操作和设置。

import docx

import os
from docx import Document
from tqdm import tqdm

path = r"E:\Hadoop_Work\data\docx" #Enter Your Absoult Path Here!

def docx2txt(path):
    """
    将docx转为txt
    """
    txt_count = 1
    for i in os.listdir(path):
        if i.endswith('.docx') and not i.startswith('~$'):
            file_path = os.path.join(path, i)
            document = Document(file_path)
            txt_path = os.path.join(path, str(txt_count)+'.txt')
            f = open(txt_path, 'w', encoding='utf-8')
            for paragraph in tqdm(document.paragraphs):
                f.write(paragraph.text.strip()+'\n')
            f.close()
            txt_count += 1

# def print_hi(name):
#     # 在下面的代码行中使用断点来调试脚本。
#     print(f'Hi, {name}')  # 按 Ctrl+F8 切换断点。


# 按装订区域中的绿色按钮以运行脚本。
if __name__ == '__main__':
    docx2txt(path)

# 访问 https://www.jetbrains.com/help/pycharm/ 获取 PyCharm 帮助

# -*- coding:utf-8 -*-
