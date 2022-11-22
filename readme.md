graalvm

## 操作系统

MacOS 13.0.1 (22A400)

## install graalvm
下载安装文件到 $HOME/Downloads 目录下:
* graalvm-ce-java11-darwin-amd64-22.3.0.tar.gz
* native-image-installable-svm-java11-darwin-amd64-22.3.0.jar

```
$ cd $HOME/Downloads
$ wget https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-22.3.0/graalvm-ce-java11-darwin-amd64-22.3.0.tar.gz
$ wget https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-22.3.0/native-image-installable-svm-java11-darwin-amd64-22.3.0.jar
```


安装 graalvm-ce-java11-darwin-amd64-22.3.0.tar.gz

```
$ cd $HOME/Downloads
$ tar -zvxf graalvm-ce-java11-darwin-amd64-22.3.0.tar.gz
$ cp -r  graalvm-ce-java11-22.3.0 /Library/Java/JavaVirtualMachines/
```

配置环境变量

```
$ cd ~
$ vim .bash_profile
JAVA_HOME=/Library/Java/JavaVirtualMachines/graalvm-ce-java11-22.3.0/Contents/Home
PATH=$JAVA_HOME/bin:$PATH
$ source ~/.bash_profile
```


安装native-image

```
$ gu install -L $HOME/Downloads/native-image-installable-svm-java11-darwin-amd64-22.3.0.jar
```

编译 hello 项目 hellworld
```
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        String str = "Native Image is awesome";
        String reversed = reverseString(str);
        System.out.println("The reversed string is: " + reversed);
    }

    public static String reverseString(String str) {
        if (str.isEmpty())
            return str;
        return reverseString(str.substring(1)) + str.charAt(0);
    }

}

```

```
$ javac HelloWorld.java
$ native-image HelloWorld

================================================================================
GraalVM Native Image: Generating 'helloworld' (executable)...
...
Finished generating 'helloworld' in 1m 11s.

$ ./helloworld 
The reversed string is: emosewa si egamI evitaN
```
