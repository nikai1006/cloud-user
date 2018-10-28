#! /bin/bash
main_path=/usr/local/redis
install_name=redis-4.0.10.tar.gz
install_path=/usr/local/redis/

env_fun()
{
echo "---检测本机环境----"

cd /usr/local/redis/redis-4.0.10                      ###这个命令是因为本地用户的操作限制，由于个人规范安装都是创建文件的，所以用该命令判断是否安装了redis。没有想到和windows下程序管理一样的判                                                                                    断命令。如果有的话欢迎交流
       if [[ $? -ne 0 ]]; then                                ##$?判断上个命令是否正确执行，正确执行为0.因此为redis已安装
#        if [[ -z $username ]]; then
                echo "redis不存在"
                return 10
        else
                echo "redis存在"
                return 12
        fi
}

install_fun(){

echo "建立redis文件夹"
mkdir -p /usr/local/redis
cd $main_path
echo "正在下载。请稍等..."
wget http://download.redis.io/releases/redis-4.0.10.tar.gz
echo "正在解压，请稍等..."
cd /usr/local/redis
tar -zxvf $install_name
echo "安装完成"
rm -rf /usr/local/redis/redis-4.0.10.tar.gz
echo "move tar packet over"
cd redis-4.0.10
echo "begin make&make install"
make
make install
}

main(){
echo "***安装redis***"
sleep 1
env_fun
re=$?
if [ 10 -eq $re ] ;then
        install_fun
else
       echo "redis已存在，不需要安装"
fi
}
main
exit 0
