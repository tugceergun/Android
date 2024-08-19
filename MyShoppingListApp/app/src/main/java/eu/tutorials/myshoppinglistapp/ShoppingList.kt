package eu.tutorials.myshoppinglistapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

data class ShoppingItem(
    val id: Int,
    var name:String,
    var quantity:Int,
    val isEditing: Boolean = false,
)


@Composable
fun ShoppingListApp(){

    //state olarak liste tutuyoruz. Shopping item data classını liste olarak.
    var sItems by remember{ mutableStateOf(listOf<ShoppingItem>()) }
    var showDialog by remember { mutableStateOf(false)}
    var itemName by remember { mutableStateOf("") }
    var itemQuantity by remember { mutableStateOf("") }
    //edit text kısmina yazildigi icin quantity'i string aldik.
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ){

        Button(
            //add item butonuna tiklayinca showDialog true olsun. Alert dialog acilacak.
            onClick = { showDialog=true},
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text ="Add item")
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)

        ){
            //lazy column'un icerigi
            items(sItems){
                item ->
                if(item.isEditing){
                    ShoppingItemEditor(item = item, onEditComplete = {
                        editedName, editedQuantity ->
                        sItems= sItems.map{it.copy(isEditing = false)}
                        //duzenleme bitti.
                        val editedItem = sItems.find { it.id == item.id }
                        //su anda duzenlemekte oldugumuz ogeyi buluyoruz.
                        editedItem?.let {
                            it.name=editedName
                            it.quantity = editedQuantity
                        }
                    })
                }else{
                    ShoppingListItem(item = item ,
                        onEditClick = {
                        //duzenledigimiz itemi buluyoruz ve isEditing'i true yapiyoruz.
                        sItems = sItems.map{it.copy(isEditing = it.id==item.id)}
                    },
                        onDeleteClick = {
                        sItems = sItems-item
                    })
                        

                }

            }
        }
    }

    if(showDialog){

        //onDismissRequest her cagirildiginda showDialog false olsun.
        AlertDialog(onDismissRequest = { showDialog = false },
            confirmButton = {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween){
                                Button(onClick = {
                                    if(itemName.isNotBlank()){
                                        val newItem= ShoppingItem(
                                            id = sItems.size+1,
                                            name= itemName,
                                            quantity = itemQuantity.toInt()
                                        )
                                        sItems = sItems + newItem
                                        showDialog = false
                                        itemName = ""
                                    }
                                }) {
                                    Text( "Add")
                                }
                                Button(onClick = { showDialog=false }) {
                                    Text("Cancel")
                                }
                            }
            },
            title= { Text( "Add Shopping Item")},
            text ={
                Column {
                    OutlinedTextField(
                        value = itemName,
                        onValueChange = {itemName= it},
                        singleLine = true,
                        //modifier = Modifier.fillMaxWidth().size(8.dp)
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                    )

                    OutlinedTextField(
                        value = itemQuantity,
                        onValueChange = {itemQuantity= it},
                        singleLine = true,
                        //modifier = Modifier.fillMaxWidth().size(8.dp)
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                    )
                }
            }
            )
        

    }
}

//edit kismi.
@Composable
fun ShoppingItemEditor(item: ShoppingItem, onEditComplete: (String,Int) -> Unit){
    var editedName by remember { mutableStateOf(item.name) }
    var editedQuantity by remember { mutableStateOf(item.quantity.toString() )}
    var isEditing by remember { mutableStateOf(item.isEditing) }

    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
        .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Column {
            BasicTextField(
                value = editedName,
                onValueChange = {editedName=it},
                singleLine = true,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            )
            BasicTextField(
                value = editedQuantity,
                onValueChange = {editedQuantity=it},
                singleLine = true,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            )


        }
            Button(onClick = {
                isEditing=false
                onEditComplete(editedName, editedQuantity.toIntOrNull() ?: 1)
            }) {
                Text("Save")
            }
        
    }
}


//shopping list icindeki itemler.
@Composable
fun ShoppingListItem(
    //kendi clickable fonkumuzu olusturduk gibi. Lambda expression.
    item: ShoppingItem,
    onEditClick:() -> Unit,
    onDeleteClick: () -> Unit,
){
    Row(
        modifier= Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(
                border = BorderStroke(2.dp, Color(0XFF018786)),
                shape = RoundedCornerShape(20)
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(text= item.name ,modifier = Modifier.padding(8.dp))
        Text(text= "Qty: ${item.quantity}" ,modifier = Modifier.padding(8.dp))
        Row(modifier = Modifier.padding(8.dp)){
            IconButton(onClick = onEditClick) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null )
            }

            IconButton(onClick = onDeleteClick) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null )
            }
        }

    }
}