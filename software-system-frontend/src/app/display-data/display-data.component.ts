import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-display-data',
  templateUrl: './display-data.component.html',
  styleUrls: ['./display-data.component.css']
})
export class DisplayDataComponent implements OnInit {

  data: any;
  allMessages: any;

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
  }

  sendRequest() {
    this.dataService.sendRequestToServer().subscribe(response => {
      console.log("Got response from the server!")
      this.data = response;
    }, error => {
      console.error('There was an error!', error);
    });
  }

  getAllData() {
    this.dataService.getAllDataFromServer().subscribe(response => {
      console.log("Got response from the server!")
      this.allMessages = response;
    }, error => {
      console.error('There was an error!', error);
    });
  }
}
