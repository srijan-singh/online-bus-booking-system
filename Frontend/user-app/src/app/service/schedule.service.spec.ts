import { TestBed } from '@angular/core/testing';

import { ScheduleService } from './schedule.service';

describe('ScheduleService', () => {
  let service: ScheduleService;

  beforeEach(() => {
    TestBed.configureTestingModule({}); // Configure TestBed for testing

    service = TestBed.inject(ScheduleService); // Inject the ScheduleService
  });

  it('should be created', () => {
    expect(service).toBeTruthy(); // Ensure that the service is created
  });
});
