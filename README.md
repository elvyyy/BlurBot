# Документация проекта
### СОДЕРЖАНИЕ 
1. [Введение](#1)
2. [Требования пользователя](#2) <br>
  2.1. [Программные интерфейсы](#2.1) <br>
  2.2. [Интерфейс пользователя](#2.2) <br>
  2.3. [Характеристики пользователей](#2.3) <br>
  2.4. [Предложения и зависимости](#2.4) <br>
3. [Системные требования](#3) <br>
  3.1 [Функциональные требования](#3.1) <br>
  3.2 [Нефункциональные требования](#3.2) <br>
    3.2.1 [Атрибуты качества](#3.2.1) <br>
    3.2.2 [Ограничения](#3.2.2) <br>
4. [Аналоги](#4) <br>
 
### 1. Введение <a name="1"></a>
Данный бот предоставляет быстрое сокрытие лиц на фотографии.
### 2. Требования пользователя <a name="2"></a>
#### 2.1. Программные интерфейсы <a name="2.1"></a>
 * Бот использует платформу [telegram-dl](https://telegram.org/) для взаимодействия с пользователем.
 * [telegram API](https://core.telegram.org/) для взаимодействия с платформой Telegram. <br>
 * Spring Boot
 * JUnit 5.1 - Фреймворк для создания модульный тестов.
#### 2.2. Интерфейс пользователя <a name="2.2"></a>
* Пользовательский интерфейс при первом использовании. <br>
    ![start-frame.png](https://github.com/elvyyy/BlurBot/blob/master/img/start-frame.png)
    <p/>
* Пользователь отправил сообщение неверного формата. <br>
    ![sending-not-image-frame.png](https://github.com/elvyyy/BlurBot/blob/master/img/sending-not-image-frame.png)
    <p/>
* Пользователь отправил сообщение в правильном формате. <br>
    ![sending-image.png](https://github.com/elvyyy/BlurBot/blob/master/img/sending-image.png)
    <p/>
#### 2.3. Характеристики пользователей <a name="2.3"></a>
 Целевая аудитория бота — иформационные ресурсы.
 
#### 2.4. Предложения и зависимости <a name="2.4"></a>
  Данный бот поддерживатеся на всех устройствах, где установлен Telegram.
 
 ### 3. Системные требования <a name="3"></a>
 #### 3.1. Функциональные требования <a name="3.1"></a>
 
 Пользователю предоставлены следующие возможности:
   1. Начать диалог с ботом;
   2. Взаимодействовать с ботом посредством отправки ему сообщений;
   3. Получать от бота файлы изображений;
   4. Удалить бота.
   
 #### 3.2 Нефункциональные требования <a name="3.2"></a>
 
  #### 3.2.1 Атрибуты качества <a name="3.2.1"></a>
  <a name="requirements_for_ease_of_use"/>
  
  * Простота использования - интуитивно понятный интерфейс.
  * Модульное тестирования для проверки правильности работы проекта.
  
 ### 4. Аналоги <a name="4"></a>
  [Skitch](https://apps.apple.com/us/app/skitch-snap-mark-up-send/id490505997) — бесплатное приложение, с дополнительными покупками внутри. Совместимо с iOS.
