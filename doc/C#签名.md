``` 
using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

namespace SignCalcApplication
{
   class SignCalc
   {
      static void Main(string[] args)
      {
        string appKey = "";
        string appSecret = "";
        long timestamp = DateTimeOffset.Now.ToUnixTimeMilliseconds();
        string requestBody = "";
         Console.WriteLine(get32MD5(appKey, appSecret, timestamp, requestBody));
      }

    // version 3 的签名算法
      static string get32MD5(string appKey, string appSecret, long timestamp, string requestBody) {
        string plaintext = appKey + appSecret + timestamp + requestBody;
        Console.WriteLine(plaintext);

        MD5 md5 = MD5.Create();

        byte[] s = md5.ComputeHash(Encoding.UTF8.GetBytes(plaintext));

        string ciphertext = "";
        for (int i = 0; i < s.Length; i++)
        {
            ciphertext = ciphertext + s[i].ToString("x2");
        }

        return ciphertext;
      }
   }
}
```
