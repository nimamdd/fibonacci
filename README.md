# fibonacci

در این سوال شما باید تابع فیبوناچی را به صورت recursive پیاده سازی کنید. توجه کنید که پیاده سازی iterative نمره‌ای نخواهد داشت. (یعنی در این تمرین مجاز به استفاده از حلقه for یا while نیستید.)

**تابع فیبوناچی**، تابعی معروف است که نمایش *بازگشتی* آن به این صورت است که هر جمله‌ی آن با توجه به دو جمله قبلی‌اش محاسبه می‌شود. 
<pre>
fib(0) = 0  
fib(1) = fib(2) = 1  
fib(n) = fib(n-1) + fib(n-2)
</pre>


در جدول زیر نمونه‌هایی از ورودی و خروجی‌های این تابع داده شده است:

|        ورودی       |        خروجی       |
|:------------------:|:------------------:|
|         0         |          0        |
|         1         |          1        |
|         2         |         1        |
|         3         |          2        |
|         4         |          3        |
|         5         |          5        |
|         10         |          55        |
|         15         |         610        |

 **پیاده‌سازی بازگشتی:**
```c
int fib(int n)
{
	if(n==0)
		return 0;
	if(n==1 || n==2)
		return 1;
	return fib(n-1)+fib(n-2);
}
```



# ورودی
ورودی تنها شامل یک خط است که در آن عدد طبیعی $n$  آمده است. (در این سوال در خط اول تعداد تست داده نمیشود و فقط عدد ورودی تابع فیبوناچی ورودی مسئله است.)

# خروجی

خروجی برنامه‌ی شما باید شامل تنها یک خط است که در آن مقدار fib(n)  آمده است.

# مثال
## ورودی نمونه ۱
```
1
```


## خروجی نمونه ۱
```
1
```


## ورودی نمونه ۲
```
18
```


## خروجی نمونه ۲
```
2584
```
