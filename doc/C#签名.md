# 说明
> 以下是来自C#技术栈的开发者提供的C#签名和加密的代码, 供大家参考


```aidl
        /// <summary>

        /// signature  签名计算结果；生成秘钥串

        /// </summary>

        /// <param name="dicPublic"></param>

        /// <param name="dicBusiness"></param>

        /// <param name="devPwd"></param>

        /// <param name="logMsg"></param>

        /// <returns></returns>

        public string GetSign(IDictionary<string, object> dicPublic, IDictionary<string, object> dicBusiness,

            string devPwd)

        {

            var dic = dicPublic;

            foreach (var item in dicBusiness)

            {

                //排除泛型

                if (!item.Value.GetType().IsGenericType)

                {

                   // if(item.Value.GetType().i)

                    dic.Add(item);

                }

            }

            dic.Add("appSecret", devPwd);

            //logMsg = $"生成签名 所有参数:{dic.ToJson()}\r\n";

            var sortStr = dic.DicToQueryString(true, "signature,requestBody");

            var bforeEncryption = "key" + sortStr + "secret";

            //logMsg += $"\r\n加密前签名:{bforeEncryption}\r\n";

            var signature = SHA1Helper.SHA1Encrypt(bforeEncryption);

            //logMsg += $"\r\n签名结果:{signature}";

            dic.Remove("devPwd");

            return signature.ToUpper();

        }



        /// <summary>

        /// AES加密（requestBody业务参数加密方法）

        /// </summary>

        /// <param name="text">明文字符串</param>

        /// <param name="key">秘钥</param>

        /// <param name="iv">加密辅助向量</param>

        /// <returns>密文</returns>

        public static string AESEncrypt(string text, string key, string iv)

        {

            RijndaelManaged rijndaelCipher = new RijndaelManaged();

            rijndaelCipher.Mode = CipherMode.CBC;

            rijndaelCipher.Padding = PaddingMode.Zeros;

            rijndaelCipher.KeySize = 128;

            rijndaelCipher.BlockSize = 128;

            byte[] pwdBytes = System.Text.Encoding.UTF8.GetBytes(key);

            byte[] keyBytes = new byte[16];

            int len = pwdBytes.Length;

            if (len > keyBytes.Length) len = keyBytes.Length;

            System.Array.Copy(pwdBytes, keyBytes, len);

            rijndaelCipher.Key = keyBytes;

            byte[] ivBytes = System.Text.Encoding.UTF8.GetBytes(iv);

            rijndaelCipher.IV = ivBytes;

            ICryptoTransform transform = rijndaelCipher.CreateEncryptor();

            byte[] plainText = Encoding.UTF8.GetBytes(text);

            byte[] cipherBytes = transform.TransformFinalBlock(plainText, 0, plainText.Length);

            return Convert.ToBase64String(cipherBytes);

        }
```