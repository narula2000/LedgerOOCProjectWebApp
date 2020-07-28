<template>
<v-app class="theme--light">
<nav>

      <v-spacer ></v-spacer>

      <v-spacer ></v-spacer>


      <v-toolbar-title class="text-center">User History</v-toolbar-title>

      <v-spacer></v-spacer>

      <v-btn  class="mr-3" text medium color="white"> <router-link to="/login" tag="li"> <span>sign-out </span> </router-link>

      <v-icon color="white">mdi-exit-to-app</v-icon>
      </v-btn>



  <v-data-table
    :headers="headers"
    :items="date"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>
  </nav>
</v-app>
</template>


<script>
  export default {
    data () {
      return {
        headers: [
          {
            text: 'date ',
            align: 'start',
            sortable: false,
            value: 'date',
          },
          { text: 'Categories', value: 'c' },
          { text: 'Value', value: 'v' },
          { text: 'Changes', value: 'ch' },
        ],
        date: [
          {
            date: '01/07/20',
            c: 'Salary',
            v: 2000,
            ch: 'Income',
            protein: 4.0,
            iron: '1%',
          },
          {
            date: '03/07/20',
            c: 'Dividends',
            v: 20000,
            ch: 'Income',
            protein: 4.0,
            iron: '1%',
          },
         {
            date: '04/07/20',
            c: 'Health',
            v: 1200,
            ch: 'Expense',
            protein: 4.0,
            iron: '1%',
          },
          {
            date: '04/07/20',
            c: 'Lottery',
            v: 3000,
            ch: 'Income',
            protein: 4.0,
            iron: '1%',
          },
          
        ],
      }
    },
  }
</script>