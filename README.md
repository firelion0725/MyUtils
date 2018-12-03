[![](https://jitpack.io/v/firelion0725/MyUtils.svg)](https://jitpack.io/#firelion0725/MyUtils)
# project gradle
`   repositories {
      maven { url 'https://jitpack.io' }
     }
     `
# app gradle
`  dependencies {
       implementation 'com.github.firelion0725:MyUtils:v1.1.0'
    }
`


# MyUtils
一个自用工具类

# API
##  ActivityUtils:
*  addFragmentToActivity: activity中增加fragment
*  goActivity: 跳转activity 带ActivityNotFoundException检测

##  DeviceUtils：设备相关工具类
*  getAndroidID：获取设备AndroidID
*  getIMEI：获取IMEI码 需添加权限READ_PHONE_STATE
*  getIMSI：获取IMSI码 需添加权限READ_PHONE_STATE
*  getModel：获取设备型号
*  getMac：获取网卡地址
*  getIpAddressString: 获取IP地址
  
##  FormatUtils 格式化工具类
*  formatChange： 将指定的字符串转换成制定小数点位数的String字符串
*  formatChangeToDouble： 将指定的字符串转换成制定小数点位数的Double
*  formatChangeToFloat：将指定的字符串转换成制定小数点位数的Float
*  formatChange2：舍弃小数点的String字符串
*  formatChangeToInteger：将指定的字符串转换成制定小数点位数的Integer
*  add：小数的相加
##  IntentUtils 意图快捷工具
*  getDialIntent： 跳至拨号界面
*  getCaptureIntent： 拍照的意图
*  getInstallAppIntent： 安装App(支持7.0)
## MyPackageUtils 包工具
*  getSdkVersion： 获取系统版本号
*  getPackageInfo： 获取包名信息
*  getVersionName： 获取版本名
*  getVersionCode： 获取版本号
*  getPackageName： 获取包号
*  getChannelID： 获取Meta中标签数据
## MySharedPreferences 注册表读写类
*  writeToSharedPreferences： 写入注册表（键值对）
*  writeStringMapToSharedPreferences：写入注册表（MAP）
*  readStringFromSharedPreferences：读取注册表（String）
*  readBooleanFromSharedPreferencesDefaultFalse： 读取注册表（Boolean 默认返回false）
*  readBooleanFromSharedPreferencesDefaultTrue：读取注册表（Boolean 默认返回true）
*  readIntFromSharedPreferences：读取注册表（Int）
*  readLongFromSharedPreferences：读取注册表（Long）
*  readFloatFromSharedPreferences：读取注册表（Float）
## RegexUtils 正则表达式工具
*  isTel：验证电话号码
*  isIDCard18：验证身份证号码18位
*  isEmail：验证邮箱
*  isMatch：判断是否匹配正则
## ScreenUtils 屏幕工具类
*  getScreenWidth：获取屏幕的宽度（单位：px）
*  getScreenHeight：获取屏幕的高度（单位：px）
*  dp2px： dp转px
*  px2dp： px转dp
*  sp2px： sp转px
*  px2sp： px转sp
*  measureView: 测量视图尺寸
*  getMeasuredWidth： 获取测量视图宽度
*  getMeasuredHeight： 获取测量视图高度
## SDCardUtils SD卡工具类
*  ishasCard：是否有SD卡
*  getSDCardPath： SD卡路径
*  getSDFreeSize： SD卡剩余空间大小
*  makeDirs：创建目录
*  deleteFile：删除文件
## StringUtils String工具类
*  stringAppend： 字符串连接
*  isConSpeCharacters 判断是否为汉字数字英文大小写
## TimeUtils 时间工具类
*  millis2String：将时间戳转为时间字符串
*  isSameDay：是否为同一天
## ThreadUtils 线程池工具类
*  createThreadPool：自定义创建线程池
*  doSomeBackgroundWork：标准Android线程处理runnable
*  doSomeLightWeightBackgroundWork：轻量级处理runnable
*  doSomeMainThreadWork：主线程处理runnable
*  doSomeTaskAtHighPriority：带权重的轻量级处理runnable
## ImageUtils 图片工具类
* drawableToBitmap drawable转换为bitmap
* bitmapToDrawable bitmap转换为drawable?
