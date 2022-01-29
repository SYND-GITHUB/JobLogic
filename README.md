# JobLogic

## Features

The demo app has three types of data to be shown in separate listings on different screens.
For demo purposes, data on two screens will be fetched from web API endpoints, and on one
screen, you will fetch data from a local store.
 
## MVVM pattern

- **Model** 
  - Two types: Person and Product Item
 
- **View** 
  - Request data from ViewModel
  
  - Observe ViewModel LiveData for response  

- **ViewModel**  
  - Contain all LiveData of DataModels   
  
  - Call getApi from Repository
  
  - Send requested param and live data to Repository  

- **Repository** 
  - Get RequestData and LiveData as Param from ViewModel 
  
  - Decide to fetch data from Network/Local Database 
  
  - Fetch data and post it on LiveData get from ViewModel
            
## Libraries   

- **Koin**  Library is used for Define DI-Dependencies Injections

- **Retrofit2** Used to call Data Fetch from network

- **Kotlin Coroutines** Used to Define a thread or scope to call API's 

- **RoomDB** Used to store/Fetch data from Database

## Guideline

- **Create local database:** CREATE TABLE "ItemToSell" ( "id" INTEGER NOT NULL, "name" TEXT NOT NULL, "price" REAL NOT NULL, "quantity" INTEGER NOT NULL, "type" INTEGER NOT NULL, PRIMARY KEY("id") )
- **Add local database to source:** Save db file as "synd_joblogic.db", then copy it to the asset/storage directory, edit file [config.properties] to provide file path. Now it's locating at assets/database/synd_joblogic.db



