<template>
<v-app class="theme--light">
<nav>

      <v-toolbar-title class="text-center">User Profile</v-toolbar-title>

      <v-spacer></v-spacer>
    
      <v-btn to="/login" class="mr-3" text medium color="black"> 
      <span>sign-out </span>
      <v-icon color="black">mdi-exit-to-app</v-icon>
      </v-btn>

      

  <v-data-table
    :headers="headers"
    :items="deposit"
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
            text: 'Name',
            align: 'start',
            sortable: false,
            value: 'name',
          },
          { text: 'change'},
          { text: 'Use'},
          { text: 'Final' },
        ],
        
      }
    },
  }
</script>