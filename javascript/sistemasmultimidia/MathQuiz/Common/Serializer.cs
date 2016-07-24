using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
using System.Xml;
using System.Xml.Serialization;

namespace MathQuiz.Common
{
    public class Serializer
    {
        /// <summary>
        /// Serializes an object.
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="serializableObject"></param>
        /// <param name="fileName"></param>
        public static void SerializeObject<T>(T serializableObject, string fileName)
        {
            if (serializableObject == null) { return; }

            try
            {
                XmlSerializer writer = new XmlSerializer(serializableObject.GetType());
                StreamWriter file = new StreamWriter(fileName);
                writer.Serialize(file, serializableObject);
                file.Close();
            }
            catch (Exception ex)
            {
                throw new Exception("Erro ao serializar objeto: " + ex.Message);
            }
        }


        /// <summary>
        /// Deserializes an xml file into an object list
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="fileName"></param>
        /// <returns></returns>
        public static T DeSerializeObject<T>(string fileName)// where T : new()
        {
            if (string.IsNullOrEmpty(fileName)) { return default(T); }

            //T objectOut = new T();
            T objectOut = default(T);

            if (!File.Exists(fileName))
                return objectOut;

            try
            {
                string attributeXml = string.Empty;

                XmlDocument xmlDocument = new XmlDocument();
                xmlDocument.Load(fileName);
                string xmlString = xmlDocument.OuterXml;

                using (StringReader read = new StringReader(xmlString))
                {
                    Type outType = typeof(T);

                    XmlSerializer serializer = new XmlSerializer(outType);
                    using (XmlReader reader = new XmlTextReader(read))
                    {
                        objectOut = (T)serializer.Deserialize(reader);
                        reader.Close();
                    }

                    read.Close();
                }
            }
            catch (Exception ex)
            {
                throw new Exception("Erro ao deserializar objeto: " + ex.Message);
            }

            return objectOut;
        }
    }
}
