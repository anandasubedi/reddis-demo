# reddis-demo
Learn about Reddis

## Installation of Reddis Server ( Ubuntu )

```
sudo apt install redis-server
```
Use ``` redis-cli ``` command to open redis cli interface

### Redis Commands

#### Check if a key exists 
``` EXISTS <myKey> ```
#### Get Value of existing Key
``` GET <myKey> ```
#### SET or APPEND  key 
``` SET <myKey> "Hello" ```
``` APPEND <myKey> " World!" ```
SET is used to add expiration time to the Key as well,
APPEND creates a new key if doesn't exists 

