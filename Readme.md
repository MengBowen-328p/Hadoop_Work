# Hadoop 专周实验--使用MapReduce实现词频统计

# 目录
[TOC]

## 文件树
```
.
├── DocxtoTxt                   docx转txt
│   └── main.py
├── Hadoop大数据技术实践.docx     实验说明书
├── Readme.md
├── WordCountTopN               词频统计
│   ├── pom.xml
│   └── src
│       └── main
│           └──...
│               └── Main.java
└── data                        原始数据
    ├── data.zip
    ├── docx
    │   ├── 1099.doc
    │   ├── 1284.docx
    │   ├── 1302.docx
    │   └── ...
    └── txt
        ├── 1.txt
        ├── 10.txt
        └── ...
```

## 集群网络配置--ZeroTier
ZetoTier是一个多平台的虚拟局域网组网应用，本项目使用ZeroTier作为集群快速组网工具。

### 安装ZeroTier
在Centos/Ubuntu等Linux操作系统上安装ZeroTier:    
如果使用SSL认证    
``` curl -s https://install.zerotier.com | sudo bash ```
如果使用GPG认证    
``` 
curl -s 'https://raw.githubusercontent.com/zerotier/ZeroTierOne/master/doc/contact%40zerotier.com.gpg' | gpg --import && \  
if z=$(curl -s 'https://install.zerotier.com/' | gpg); then echo "$z" | sudo bash; fi
```

### 通过ID加入虚拟网络
集群的虚拟网络ID是:41d49af6c2e8a62e    
使用zerotiercli命令加入虚拟网络:    
``` zerotiercli -join 41d49af6c2e8a62e ```

##
